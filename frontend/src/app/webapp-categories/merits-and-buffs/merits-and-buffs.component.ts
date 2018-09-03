import { Component, OnInit } from '@angular/core';
import { Modifiers, ModifierEntry } from '../../data/Modifiers';
import { MeritsAndBuffsService } from '../../services/merits-and-buffs.service';
import { CharacterService } from '../../services/character.service';
import { CharacterSheet } from '../../data/characterSheet';

@Component({
  selector: 'app-merits-and-buffs',
  templateUrl: './merits-and-buffs.component.html',
  styleUrls: ['./merits-and-buffs.component.css']
})
export class MeritsAndBuffsComponent implements OnInit {
  modifiers: Modifiers;
  statusFromServerAfterUpdatingModifiers: string;

  modifierEntries: ModifierEntry[];
  modifierEntry1: ModifierEntry = { modifierName:"", modifierAmount:0, whatModified:""};
  modifierEntry2: ModifierEntry = { modifierName:"", modifierAmount:0, whatModified:""};
  modifierEntry3: ModifierEntry = { modifierName:"", modifierAmount:0, whatModified:""};
  modifierEntry4: ModifierEntry = { modifierName:"", modifierAmount:0, whatModified:""};
  modifierEntry5: ModifierEntry = { modifierName:"", modifierAmount:0, whatModified:""};
  modifierEntry6: ModifierEntry = { modifierName:"", modifierAmount:0, whatModified:""};
  modifierEntry7: ModifierEntry = { modifierName:"", modifierAmount:0, whatModified:""};
  modifierEntry8: ModifierEntry = { modifierName:"", modifierAmount:0, whatModified:""};

  buildMeritsAndBuffsObject() {
    this.modifierEntries = [];
    this.modifierEntries.push(this.modifierEntry1);
    this.modifierEntries.push(this.modifierEntry2);
    this.modifierEntries.push(this.modifierEntry3);
    this.modifierEntries.push(this.modifierEntry4);
    this.modifierEntries.push(this.modifierEntry5);
    this.modifierEntries.push(this.modifierEntry6);
    this.modifierEntries.push(this.modifierEntry7);
    this.modifierEntries.push(this.modifierEntry8);
  }

  initializeModifiersObject() {
    this.modifiers = {
      modifiersId : 1,
      characterSheetId : 1,
      speedMod : 0,
      assessmentMod : 0,
      insightMod : 0,
      spiritMod : 0,
      coordinationMod : 0,
      strengthMod : 0,
      fortitudeMod : 0,
      wisdomMod : 0,
      willMod : 0,
      presenceMod : 0,

      martialMod : 0,
      martialProficiencyMod : 0,
      rangedMod : 0,
      rangedProficiencyMod : 0,
      stealthMod : 0,
      stealthProficiencyMod : 0,
      athleticsMod : 0,
      athleticsProficiencyMod : 0,

      loreMod : 0,
      loreProficiencyMod : 0,
      scoutingMod : 0,
      scoutingProficiencyMod : 0,
      alchemyMod : 0,
      alchemyProficiencyMod : 0,
      craftingMod : 0,
      craftingProficiencyMod : 0,

      artsMod : 0,
      artsProficiencyMod : 0,
      diplomacyMod : 0,
      diplomacyProficiencyMod : 0,

      forceMod : 0,
      shotStrengthMod : 0,
      shotDistanceMod : 0,
      PowerMod : 0,
      martialCritMod : 0,
      rangedCritMod : 0,
      defenseMod : 0,
      resolveMod : 0,
      deflectMod : 0,
      moveMod : 0,
      initiativeMod : 0
    }
  }

  buildModifiersObject() {
    this.modifierEntries.forEach(modEntry => {
      Object.entries(this.modifiers).forEach(modType => {
        let nameOfAttributeModified = modEntry.whatModified.toLowerCase() + "Mod";
        if (nameOfAttributeModified == modType[0]) {
          this.modifiers[nameOfAttributeModified] += +modEntry.modifierAmount;
        }
      })
    });
  }

  updateMeritsAndBuffs() {
    this.initializeModifiersObject(); //zero out mods
    this.buildMeritsAndBuffsObject(); 
    this.buildModifiersObject();
    this.meritsAndBuffsService.updateMeritsAndBuffs(this.modifiers)
      .subscribe(serverResponse => {
        this.statusFromServerAfterUpdatingModifiers = serverResponse;
      })
  }

  getModifierEntries(modifierId) {

  }

  constructor(private meritsAndBuffsService: MeritsAndBuffsService,
              private characterService: CharacterService) { }

  ngOnInit() {
    this.modifierEntries = [{ modifierName: "",
                              whatModified: "", 
                              modifierAmount: 0
                            }];
    this.getModifierEntries(1); //fake modifierId for now
    this.initializeModifiersObject();
  }
}