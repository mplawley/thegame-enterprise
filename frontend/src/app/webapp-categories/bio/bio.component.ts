import { Component, OnInit } from '@angular/core';
import { Bio } from '../../data/bio';
import { BioService } from '../../services/bio.service';

@Component({
  selector: 'app-bio',
  templateUrl: './bio.component.html',
  styleUrls: ['./bio.component.css']
})
export class BioComponent implements OnInit {
  bio: Bio;

  updateBio(bio: Bio): void {
    this.bio.bioId = 2;    
    this.bioService.updateBio(this.bio)
      .subscribe(bioObject => {
        this.bio = bioObject;
        this.getBio(); //Update UI after the update to the server
      })
  }

  getBio(): void {
    this.bioService.getBio('2')
      .subscribe(bioObject => {
        this.bio = bioObject;
      }
    )
  }

  constructor(private bioService: BioService) { }

  ngOnInit() {
    this.getBio();
  }

}
