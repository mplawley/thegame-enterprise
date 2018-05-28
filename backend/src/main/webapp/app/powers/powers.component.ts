import { Component, OnInit } from '@angular/core';
import { Power, Action } from '../power';
import { PowerService } from '../power.service';

@Component({
  selector: 'app-powers',
  templateUrl: './powers.component.html',
  styleUrls: ['./powers.component.css']
})
export class PowersComponent implements OnInit {
  powers;

  addPower(power: Power): void {
    this.powers.push(power);
  }

  add(name: string): void {
    name = name.trim();
    if (!name) { return; }
    this.powerService.addPower({ name } as Power)
      .subscribe(power => {
        this.powers.push(power);
      });
  }

  delete(power: Power): void {
    this.powers = this.powers.filter(p => p !== power);
    this.powerService.deletePower(power).subscribe();
  }

  getPowers(): void {
    this.powerService.getPowers()
      .subscribe(powers => this.powers = powers);
  }

  constructor(private powerService: PowerService) {}

  ngOnInit() {
    this.getPowers();
  }
}
