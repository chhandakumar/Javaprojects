import { ApplicationDataService } from '../service/data/application-data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

export class Application {
  constructor(
    public id: number,
    public EAI: string,
    public done: boolean,
    public targetDate: Date
  ){

  }
}

@Component({
  selector: 'app-list-applications',
  templateUrl: './list-applications.component.html',
  styleUrls: ['./list-applications.component.css']
})
export class ListApplicationsComponent implements OnInit {

  applications: Application[]

  message: string

  constructor(
    private applicationService:ApplicationDataService,
    private router : Router
  ) { }

  ngOnInit() {
    this.refreshApplications();
  }

  refreshApplications(){
    this.applicationService.retrieveAllApplications('fedex').subscribe(
      response => {
        console.log(response);
        this.applications = response;
      }
    )
  }

  deleteApplication(id) {
    console.log(`delete application ${id}` )
    this.applicationService.deleteApplication('fedex', id).subscribe (
      response => {
        console.log(response);
        this.message = `Delete of Application ${id} Successful!`;
        this.refreshApplications();
      }
    )
  }

  updateApplication(id) {
    console.log(`update ${id}`)
    this.router.navigate(['applications',id])
  }

  addApplication() {
    this.router.navigate(['applications',-1])
  }
}
