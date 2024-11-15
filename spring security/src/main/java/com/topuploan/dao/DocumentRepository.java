package com.topuploan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topuploan.entity.DocumentModel;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentModel, Long>{
   
    DocumentModel findByDocumentId(Long id);
    DocumentModel findByDocumentName(String fileName);
	
}
