package com.qzeng2018.springreact.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BaseDeleteReq implements Serializable {

    private static final long serialVersionUID = -7662816890503147555L;

    private String id;
    private List<String> ids;

}
