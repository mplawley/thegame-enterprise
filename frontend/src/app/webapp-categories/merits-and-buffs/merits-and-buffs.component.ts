import { Component, OnInit } from '@angular/core';
import { Modifiers, ModifierEntry } from '../../data/Modifiers';
import { MeritsAndBuffsService } from '../../services/merits-and-buffs.service';

@Component({
  selector: 'app-merits-and-buffs',
  templateUrl: './merits-and-buffs.component.html',
  styleUrls: ['./merits-and-buffs.component.css']
})
export class MeritsAndBuffsComponent implements OnInit {
  modifiers: Modifiers[];
  modifierEntries: ModifierEntry[];

  onInputModifier(modifyEntry: ModifierEntry) {
    this.modifierEntries.push(modifyEntry);
  }

  updateModifiers() {
    this.meritsAndBuffsService.updateMeritsAndBuffs(this.modifierEntries)
      .subscribe(modifierEntries => {
        this.modifierEntries = modifierEntries;
        this.getModifierEntries();
      })
  }

  getModifierEntries() {
    
  }


  
  constructor(private meritsAndBuffsService: MeritsAndBuffsService) { }

  ngOnInit() {
  }

}