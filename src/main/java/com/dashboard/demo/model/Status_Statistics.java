package com.dashboard.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Status_Statistics")
public class Status_Statistics {
	
	private String fileId;
	private String customerName;
	private String customerId;
	
	private String submitterId;
	private String subscriberId;
	
	private String fileReceivedData;

	
	public String getFileId() {
		return fileId;
	}


	public void setFileId(String fileId) {
		this.fileId = fileId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getCustomerId() {
		return customerId;
	}



	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}



	public String getSubmitterId() {
		return submitterId;
	}



	public void setSubmitterId(String submitterId) {
		this.submitterId = submitterId;
	}



	public String getSubscriberId() {
		return subscriberId;
	}



	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}



	public String getFileReceivedData() {
		return fileReceivedData;
	}



	public void setFileReceivedData(String fileReceivedData) {
		this.fileReceivedData = fileReceivedData;
	}



	@Override
	public String toString() {
		return "Status_Statistics [fileId=" + fileId + ", customerName=" + customerName + ", customerId=" + customerId
				+ ", submitterId=" + submitterId + ", subscriberId=" + subscriberId + ", fileReceivedData="
				+ fileReceivedData + "]";
	}

}
