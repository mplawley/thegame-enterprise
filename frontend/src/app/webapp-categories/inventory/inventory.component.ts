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

  onItemQualityChange(event) {
    console.log(event.target.id);
    const newItemQualitySelection = event.target.value;
    console.log(newItemQualitySelection);
  }

  constructor(private inventoryService: InventoryService) { }

  ngOnInit() {
    this.inventoryId = "1";
    this.getInventory();
  }
}
