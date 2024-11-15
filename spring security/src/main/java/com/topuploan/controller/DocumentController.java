package com.topuploan.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.topuploan.dao.DocumentRepository;
import com.topuploan.dao.FileUploadResponse;
import com.topuploan.entity.DocumentModel;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DocumentController {
	@Autowired
	private DocumentRepository docRepo;

	public DocumentController(DocumentRepository docRepo) {
		super();
		this.docRepo = docRepo;
	}

	@PostMapping("/uploadDocument")
//	@CrossOrigin(origins = "*")
	public FileUploadResponse saveDocument(@RequestParam("file") MultipartFile file,
			@RequestParam("documentType") String documentType) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		DocumentModel doc = new DocumentModel(fileName, documentType, file.getBytes());

		docRepo.save(doc);

		String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/getDocument/").path(fileName)
				.toUriString();

		String contentType = file.getContentType();

		return new FileUploadResponse(fileName,contentType,url);
	}

	@GetMapping("/getDocument/{fileName}")
	ResponseEntity<byte[]> downloadFile(@PathVariable String fileName, HttpServletRequest request) {

		DocumentModel doc = docRepo.findByDocumentName(fileName);

		String mimeType = request.getServletContext().getMimeType(doc.getDocumentName());

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(mimeType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline;fileName="+doc.getDocumentName())
				.body(doc.getDocumentUpload());

	}
	@GetMapping("/getDoc/{id}")
	Optional<DocumentModel> fileDetails(@PathVariable long id)
	{
		return docRepo.findById(id);
	}
}
