import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Power } from '../../data/power';
import { PowerService } from '../../services/power.service';

@Component({
  selector: 'app-powers-detail',
  templateUrl: './powers-detail.component.html',
  styleUrls: ['./powers-detail.component.css']
})
export class PowersDetailComponent implements OnInit {
  @Input() power: Power;

  constructor(
    private route: ActivatedRoute,
    private powerService: PowerService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.getPower();
  }

  getPower(): void {
    const powerId = +this.route.snapshot.paramMap.get('powerId');
    this.powerService.getPower(powerId)
      .subscribe(power => this.power = power);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.powerService.updatePower(this.power)
      .subscribe(() => this.goBack());
  }
}