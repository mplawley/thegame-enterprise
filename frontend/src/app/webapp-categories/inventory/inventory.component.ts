import { Component, OnInit } from '@angular/core';
import { Inventory, InventoryEntry } from '../../data/inventorySheet';
import { CharacterService } from '../../services/character.service';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: [ './inventory.component.css' ]
})
export class InventoryComponent implements OnInit {
  inventory: Inventory;

  constructor() { }

  ngOnInit() {
  }

}