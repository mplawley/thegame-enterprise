import { Component, OnInit } from '@angular/core';
import { CharacterSheet, CharacterSheetClickableItems, Proficiency, CharacterSheetVitals, CharacterSheetDataType, CharacterSheetDataObject } from '../characterSheet';
import { GameEngine } from '../gameEngine';
import { CharacterService } from '../character.service';
import { ProficiencyStringPipe } from '../proficiency-int-to-string-pipe';
import { IHash, IHashOfHash } from '../inventorySheet';

@Component({
  selector: 'app-character',
  templateUrl: './character.component.html',
  styleUrls: ['./character.component.css']
})

export class CharacterComponent implements OnInit {
  gameEngine: GameEngine = new GameEngine();

  characterSheetBaseStats;
  characterSheetSkills;
  characterSheetVitals: CharacterSheetVitals;
  
  characterSheet;
  general;
  stats;
  skills;
  proficiencies;

  selectedCharacterSheetItem: string;
  currentPerformance: number;

  onSelectStat(statName: string, statValue: number): void {
    this.selectedCharacterSheetItem = statName;
    this.currentPerformance = this.gameEngine.calculateStatPerformance(statValue);
  }

  onSelectSkill(skillName: string, skillValue: number): void {
    // this.selectedCharacterSheetItem = characterSheetItem;
    let baseAttributeName = this.gameEngine.getSkillBaseAttribute(skillName);
    let baseAttributeValue = this.stats[baseAttributeName];
    let proficiency = this.proficiencies[skillName];
    this.currentPerformance = this.gameEngine.calculateSkillPerformance(skillName, baseAttributeValue, skillValue, proficiency);
  }

  updateCharacterSheetOnUI(): void {
    console.log(this.characterSheet);
  }

  getVitals(): void {
    this.characterService.getVitals()
      .subscribe(vitals => this.characterSheetVitals = vitals);
  }

  saveVitals(): void {
    this.characterService.updateVitals(this.characterSheetVitals)
      .subscribe(result => console.log(result.json()));
  }

  getStats(): void {
    this.characterService.getStats()
      .subscribe(baseStats => this.characterSheetBaseStats = baseStats)
  }

  getSkills(): void {
    this.characterService.getSkills()
      .subscribe(skills => this.characterSheetSkills = skills);
  }

  getCharacterSheet(): void {
    this.characterService.getCharacterSheet('3')
      .subscribe(characterSheetObject => {
        this.characterSheet = this.transformObjectToIterable(characterSheetObject);
        this.general = this.characterSheet['general'];
        this.stats = Object.entries(this.characterSheet['stats']);
        this.skills = Object.entries(this.characterSheet['skills']);
        this.proficiencies = this.characterSheet['proficiencies'];
      }
    )
  }

  transformObjectToIterable(objectToTransform): any {
    let iterableObjectProperties = Object.keys(objectToTransform);
    let iterableObjectValues = Object.values(objectToTransform);
    let hashMapOfGeneralCharacterSheetEntriesAndValues: IHash = {};
    let hashMapOfStatEntriesAndValues: IHash = {};
    let hashMapOfSkillEntriesAndValues: IHash = {};
    let hashMapOfProficiencyEntriesAndValues: IHash = {};
    
    let hashMapOfHashMapsForCharacterSheet: IHashOfHash = {};

    for (var i = 0; i < iterableObjectProperties.length; i++) {
      if (this.determineCharacterSheetEntryDataType(iterableObjectProperties[i]) == CharacterSheetDataType.Stat) {
        hashMapOfStatEntriesAndValues[iterableObjectProperties[i].toString()] = iterableObjectValues[i].toString();
      } else if (this.determineCharacterSheetEntryDataType(iterableObjectProperties[i]) == CharacterSheetDataType.Skill) {
        hashMapOfSkillEntriesAndValues[iterableObjectProperties[i].toString()] = iterableObjectValues[i].toString();
      } else if (this.determineCharacterSheetEntryDataType(iterableObjectProperties[i]) == CharacterSheetDataType.Proficiency) {
        hashMapOfProficiencyEntriesAndValues[iterableObjectProperties[i].toString()] = iterableObjectValues[i].toString();
      } else {
        hashMapOfGeneralCharacterSheetEntriesAndValues[iterableObjectProperties[i].toString()] = iterableObjectValues[i].toString();
      }
    }

    hashMapOfHashMapsForCharacterSheet["general"] = hashMapOfGeneralCharacterSheetEntriesAndValues;
    hashMapOfHashMapsForCharacterSheet["stats"] = hashMapOfStatEntriesAndValues;
    hashMapOfHashMapsForCharacterSheet["skills"] = hashMapOfSkillEntriesAndValues;
    hashMapOfHashMapsForCharacterSheet["proficiencies"] = hashMapOfProficiencyEntriesAndValues;

    return hashMapOfHashMapsForCharacterSheet;
  }

  determineCharacterSheetEntryDataType(characterSheetEntry: string): CharacterSheetDataType {
    let statsArray: string[] = ["speed", "assessment", "insight", "spirit", "coordination", "strength", "fortitude", "wisdom", "will", "presence"];
    let skillsArray: string[] = ["martial", "ranged", "athletics", "stealth", "lore", "scouting", "alchemy", "crafting", "arts", "diplomacy"];
    let proficienciesArray: string[] = ["martialProficiency", "rangedProficiency", "athleticsProficiency", "stealthProficiency", "loreProficiency", "scoutingProficiency", "alchemyProficiency", "craftingProficiency", "artsProficiency", "diplomacyProficiency"];
    for (let stat of statsArray) {
      if (characterSheetEntry == stat) {
        return CharacterSheetDataType.Stat;
      }
    }

    for (let skill of skillsArray) {
      if (characterSheetEntry == skill) {
        return CharacterSheetDataType.Skill;
      }
    }

    for (let proficiency of proficienciesArray) {
      if (characterSheetEntry == proficiency) {
        return CharacterSheetDataType.Proficiency;
      }
    }
  }

  constructor(private characterService: CharacterService) {}

  ngOnInit() {
    // this.getVitals();
    // this.getStats();
    // this.getSkills();
    this.getCharacterSheet();
  }
}
