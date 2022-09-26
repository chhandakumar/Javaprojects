import { ActivatedRoute, Router } from '@angular/router';
import { ApplicationDataService } from '../service/data/application-data.service';
import { Component, OnInit } from '@angular/core';
import { Application } from '../list-applications/list-applications.component';

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.css']
})
export class ApplicationComponent implements OnInit {

  id:number
  application: Application

  constructor(
    private applicationService: ApplicationDataService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    
    this.id = this.route.snapshot.params['id'];
    
    this.application = new Application(this.id,'',false,new Date());
    
    if(this.id!=-1) {
      this.applicationService.retrieveApplication('fedex', this.id)
          .subscribe (
            data => this.application = data
          )
    }
  }

  saveApplication() {
    if(this.id == -1) { //=== ==
      this.applicationService.createApplication('fedex', this.application)
          .subscribe (
            data => {
              console.log(data)
              this.router.navigate(['applications'])
            }
          )
    } else {
      this.applicationService.updateApplication('fedex', this.id, this.application)
          .subscribe (
            data => {
              console.log(data)
              this.router.navigate(['applications'])
            }
          )
    }
  }

}
