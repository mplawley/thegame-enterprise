import { Component, OnInit } from '@angular/core';
import { Inventory, InventoryEntry } from '../../data/inventorySheet';
import { InventoryService } from '../../services/inventory-service.service';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: [ './inventory.component.css' ]
})
export class InventoryComponent implements OnInit {
  inventory: Inventory;

  getInventory(): void {
    this.inventoryService.getInventory('10')
      .subscribe(inventoryObject => {
        this.inventory = inventoryObject;
      })
  }

  constructor(private inventoryService: InventoryService) { }

  ngOnInit() {
    this.getInventory();
  }
}