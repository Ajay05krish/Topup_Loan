package com.topuploan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Lob;

@Entity
@Table(name = "document_table")
public class DocumentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long documentId;
	private String documentName;
	private String documentType;
	@Lob
	private byte[] documentUpload;
	
	public DocumentModel() {
		
	} 
	public DocumentModel(String documentName, String documentType, byte[] documentUpload) {
		super();
		this.documentName = documentName;
		this.documentType = documentType;
		this.documentUpload = documentUpload;
	}
	public Long getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public byte[] getDocumentUpload() {
		return documentUpload;
	}
	public void setDocumentUpload(byte[] documentUpload) {
		this.documentUpload = documentUpload;
	} 
	
}
