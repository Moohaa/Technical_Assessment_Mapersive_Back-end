package com.example.Insurance_API.utils;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

public class CommonResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String responseType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object result;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, Object> results;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, Object> otherDetails;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public void setResponseType(ResponseType type) {
        if (type!=null){
            this.responseType = type.name();
        }
    }

    public Map<String, Object> getResults() {
        return results;
    }

    public static CommonResponse generateResponse(ResponseType type, String message, Object result){
        CommonResponse response =  new CommonResponse();
        response.setResponseType(type);
        response.setResult(result);
        response.setMessage(message);
        return response;
    }

    public void addResult(String key, Object result) {
        if(results==null){
            results = new HashMap<>();
        }
        results.put(key, result);
    }

    public enum ResponseType{
        ERROR, SUCCESS, BAD_REQUEST, NOT_FOUND
    }

    public void setResults(Map<String, Object> results) {
        this.results = results;
    }

    public Map<String, Object> getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(Map<String, Object> otherDetails) {
        this.otherDetails = otherDetails;
    }
    public void addOtherDetail(String key, Object result) {
        if(otherDetails==null){
            otherDetails = new HashMap<>();
        }
        otherDetails.put(key, result);
    }

}

