/**
 * 
 */
package com.dashboard.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author maris
 *
 */
@Document(collection = "FileDetails")
public class DashboardDetails
{
	private String fileId;
	private String fileName;
	private String fileImportedDate;
	
	
	public String getFileId() {
		return fileId;
	}


	public void setFileId(String fileId) {
		this.fileId = fileId;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFileImportedDate() {
		return fileImportedDate;
	}


	public void setFileImportedDate(String fileImportedDate) {
		this.fileImportedDate = fileImportedDate;
	}


	@Override
	public String toString() {
		return "DashboardDetails [fileId=" + fileId + ", fileName=" + fileName + ", fileImportedDate="
				+ fileImportedDate + "]";
	}
	
	

}
