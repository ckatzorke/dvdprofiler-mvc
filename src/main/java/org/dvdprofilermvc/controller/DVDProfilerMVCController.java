package org.dvdprofilermvc.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dvdprofilermvc.io.IO;
import org.dvdprofilermvc.model.DVD;
import org.dvdprofilermvc.parsing.xml.listener.DVDLister;
import org.dvdprofilermvc.parsing.xml.stax.CollectionXmlStreamProcessor;
import org.dvdprofilermvc.repository.api.DvdProfilerRepository;
import org.dvdprofilermvc.repository.api.UpdateResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DVDProfilerMVCController {

	private final Logger logger = LoggerFactory.getLogger(DVDProfilerMVCController.class);

	@Autowired
	private IO io;

	@Autowired
	private DvdProfilerRepository repository;

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public @ResponseBody String provideUploadInfo() {
		return "You can upload a file by posting to this same URL.";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody Result handleFileUpload(@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				final long start = System.currentTimeMillis();
				final File xmlFile = upload(file);
				// now parse
				final CollectionXmlStreamProcessor staxProcessor = new CollectionXmlStreamProcessor();
				final DVDLister lister = new DVDLister();
				staxProcessor.addDVDEventListener(lister);
				staxProcessor.process(new FileInputStream(xmlFile));
				final UpdateResult updateResult = repository.update(lister.getDvds());
				final Map<String, Object> resultMap = new HashMap<String, Object>();
				resultMap.put("newCollectionSize", repository.getCount());
				final long timetaken = System.currentTimeMillis() - start;
				resultMap.put("processtime", timetaken);
				resultMap.put("updateResult", updateResult);
				final Result result = Result.createResult(resultMap);
				return result;
			} catch (final Exception e) {
				final String error = "Cannot upload and process file!";
				logger.error(error, e);
				return Result.createErrorResult(error, HttpStatus.INTERNAL_SERVER_ERROR.value());
			}
		} else {
			return Result.createResult("Ok");
		}
	}

	@RequestMapping(value = "/dvds", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<DVD> listDVDs() {
		return repository.getAll();
	}

	@RequestMapping(value = "/nope", method = RequestMethod.GET, produces = "application/json")
	public String justtesing() {
		return ",öü";
	}

	private File upload(MultipartFile file) throws IOException {
		final byte[] bytes = file.getBytes();
		final File projectFolder = io.getProjectDir();
		final String filename = new Date().getTime() + ".xml";
		final File xmlFile = new File(projectFolder, filename);
		final FileOutputStream fileOutputStream = new FileOutputStream(xmlFile);
		final BufferedOutputStream stream = new BufferedOutputStream(fileOutputStream);
		stream.write(bytes);
		stream.close();
		return xmlFile;
	}
}
