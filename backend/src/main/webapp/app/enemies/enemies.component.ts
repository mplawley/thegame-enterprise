import { Component, OnInit } from '@angular/core';
import { DEMO_ENEMIES } from '../mock-enemies';
import { Monster } from '../characterSheet';

@Component({
  selector: 'app-enemies',
  templateUrl: './enemies.component.html',
  styleUrls: ['./enemies.component.css']
})

export class EnemiesComponent implements OnInit {
  demoEnemies = DEMO_ENEMIES;

  selectedEnemy: Monster;

  onSelect(enemy: Monster): void {
    this.selectedEnemy = enemy;
  }

  constructor() { 
    console.log("demoEnemies: " + this.demoEnemies[0].name);
  }

  ngOnInit() {
  }

}
