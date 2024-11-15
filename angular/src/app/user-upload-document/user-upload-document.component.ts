import { Component, OnInit } from '@angular/core';
import { FileUploadResponse } from './file-upload-response';
import { UploaddocumentService } from '../_services/uploaddocument.service'; 

@Component({
  selector: 'app-user-upload-document',
  templateUrl: './user-upload-document.component.html',
  styleUrls: ['./user-upload-document.component.css']
})
export class UserUploadDocumentComponent implements OnInit {

  message: string | undefined;
  selectedFile: any = File;
  documentId:any;
  documentType:string;
  fileRes : any;
  viewUrl : any;

  constructor(private documentService: UploaddocumentService) {
     this.fileRes = new FileUploadResponse;
  }

  public onFileChanged(event) {
    const file = event.target.files[0];
    this.selectedFile = file;
    
  }

  public onUpload() {
    console.log(this.selectedFile);
    this.documentService.uploadDocument(this.selectedFile,this.documentType).subscribe(
      response => {
        console.log(response);
        this.fileRes = response;
        this.viewUrl = this.fileRes.url;
        this.message = `File uploaded successfully`;
      },
     
      _error => {
        this.message = 'Error! while uploading file';
      }
    );
  }

  public getFile() {

    this.documentService.getUploadedDocument(this.fileRes.fileName).subscribe(
      res => {
       console.log(res);
      },
      _err => {
        this.message = 'Error! while getting file';
      }
    );
  }

  ngOnInit(): void {
    //empty
  }

}