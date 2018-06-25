package com.intellif.jianyi.vo;

import java.io.Serializable;

public class SolrConfigInfo implements Serializable {

	private static final long serialVersionUID = 7225464949093873209L;

    private long id;
    private String serverUrl;
    private long sourceId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public long getSourceId() {
		return sourceId;
	}

	public void setSourceId(long sourceId) {
		this.sourceId = sourceId;
	}
}
