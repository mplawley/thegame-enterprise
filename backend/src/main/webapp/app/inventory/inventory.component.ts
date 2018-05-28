import { Component, OnInit } from '@angular/core';
import { Inventory, InventoryEntry } from '../inventorySheet';
import { CharacterService } from '../character.service';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: [ './inventory.component.css' ]
})
export class InventoryComponent implements OnInit {
  inventory: Inventory;

  constructor(private characterService: CharacterService) { }

  ngOnInit() {
    this.inventory.constructBasicInventory();
  }

  getHeroes(): void {
    // this.heroService.getHeroes()
    //   .subscribe(heroes => this.heroes = heroes.slice(1, 5));
  }
}