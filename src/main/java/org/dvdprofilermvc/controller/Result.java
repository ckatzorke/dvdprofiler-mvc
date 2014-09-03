package org.dvdprofilermvc.controller;

import org.springframework.http.HttpStatus;

public class Result {
	private Object result;
	private int status = HttpStatus.OK.value();
	private String error;

	private Result() {
		super();
	}

	public static Result createResult(Object result) {
		final Result r = new Result();
		r.setResult(result);
		return r;
	}

	public static Result createErrorResult(String error, int status) {
		final Result r = new Result();
		r.setError(error);
		r.setStatus(status);
		return r;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Result [result=" + result + ", status=" + status + ", error=" + error + "]";
	}

}
