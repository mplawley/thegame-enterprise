import { Component, OnInit } from '@angular/core';
import { Inventory, InventoryEntry } from '../../data/inventorySheet';
import { InventoryService } from '../../services/inventory-service.service';
import { Modifiers } from '../../data/Modifiers';
import { Proficiency } from '../../data/characterSheet';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: [ './inventory.component.css' ]
})
export class InventoryComponent implements OnInit {
  inventory: Inventory;
  inventoryId: string;
  modifiers: Modifiers;
  proficiencies: string[] = ["Apprentice", "Journeyman", "Master", "Grandmaster", "Legendary", "Epic"];

  getInventory(): void {
    this.inventoryService.getInventory(this.inventoryId)
      .subscribe(inventoryObject => {
        this.inventory = inventoryObject;
      })
  }

  updateInventory(): void {
    this.inventoryService.updateInventory(this.inventory)
      .subscribe(inventoryObject => {
        this.inventory = inventoryObject;
        // this.getInventory(); //update UI after the update to the server
      })
  }

  onItemQualityChange(event) {
    let itemWhoseQualityChanged = event.target.id.replace('Select', '');
    const newItemQualitySelection = event.target.value;
    this.inventory[itemWhoseQualityChanged].itemQuality = newItemQualitySelection;
    this.updateInventory();
  }

  constructor(private inventoryService: InventoryService) { }

  ngOnInit() {
    this.inventoryId = "1";
    this.getInventory();
  }
}
