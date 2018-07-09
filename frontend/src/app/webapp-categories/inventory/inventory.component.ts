import { Component, OnInit } from '@angular/core';
import { Inventory, InventoryEntry } from '../../data/inventorySheet';
import { InventoryService } from '../../services/inventory-service.service';
import { Modifiers } from '../../data/Modifiers';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: [ './inventory.component.css' ]
})
export class InventoryComponent implements OnInit {
  inventory: Inventory;
  inventoryId: string;
  modifiers: Modifiers;

  getInventory(): void {
    this.inventoryService.getInventory(this.inventoryId)
      .subscribe(inventoryObject => {
        this.inventory = inventoryObject;
      })
  }

  constructor(private inventoryService: InventoryService) { }

  ngOnInit() {
    this.inventoryId = "1";
    this.getInventory();
  }
}
