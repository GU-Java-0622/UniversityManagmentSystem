import { Component, OnInit } from '@angular/core';
import {AppDataRequestService} from "../../../../../../services/app-data-request.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-stream-by-id-view',
  templateUrl: './stream-by-id-view.component.html',
  styleUrls: ['./stream-by-id-view.component.css']
})
export class StreamByIdViewComponent implements OnInit {
  id: number | null;
  constructor(private dataRequest: AppDataRequestService,private router:Router,private route: ActivatedRoute,private data:AppDataRequestService,private formBuilder: FormBuilder) {
    this.id = parseInt(<string>this.route.snapshot.queryParamMap.get('id'));
  }

  ngOnInit(): void {
  }

}
