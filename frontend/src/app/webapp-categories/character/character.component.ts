import { Component, OnInit } from '@angular/core';
import { CharacterSheet, Proficiency, CharacterSheetDataType } from '../../data/characterSheet';
import { GameEngineService } from '../../services/gameEngine.service';
import { CharacterService } from '../../services/character.service';

@Component({
  selector: 'app-character',
  templateUrl: './character.component.html',
  styleUrls: ['./character.component.css']
})

export class CharacterComponent implements OnInit {
  characterSheet: CharacterSheet;
  proficiencies;
  selectedCharacterSheetItem: string;
  currentPerformance: number;

  onSelectStat(statName: string, statValue: number): void {
    this.selectedCharacterSheetItem = statName;
    this.currentPerformance = this.gameEngine.calculateStatPerformance(statValue);
  }

  onSelectSkill(skillName: string, skillValue: number): void {
    this.selectedCharacterSheetItem = skillName;
    let baseAttributeName: string = this.gameEngine.getSkillBaseAttribute(skillName);
    let baseAttributeValue: number = this.characterSheet[baseAttributeName];
    let proficiencyName = this.proficiencies[skillName + "Proficiency"];
    let proficiencyValue: number = parseInt(Proficiency[proficiencyName]);
    this.currentPerformance = this.gameEngine.calculateSkillPerformance(skillName, baseAttributeValue, skillValue, proficiencyValue);
  }

  updateCharacterSheet(): void {    
    this.characterService.updateCharacterSheet(this.characterSheet)
      .subscribe(characterSheet => {
        this.characterSheet = characterSheet;
        this.getCharacterSheet(); //Update UI after the update to the server
      })
  }

  getCharacterSheet(): void {
    this.characterService.getCharacterSheet('2')
      .subscribe(characterSheetObject => {
        this.characterSheet = characterSheetObject;
        this.populateProficienciesObject(characterSheetObject);
      }
    )
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

  populateProficienciesObject(characterSheet) {
    this.proficiencies = this.generateProficienciesHashMap(characterSheet);
  }

  generateArray(obj){
    return Object.keys(obj).map((key)=>{ return {key:key, value:obj[key]}});
  }

  generateStatsArray(obj){
    return this.generateArrayOfDataTypePassedIn(obj, CharacterSheetDataType.Stat);
  }

  generateSkillsArray(obj){
    return this.generateArrayOfDataTypePassedIn(obj, CharacterSheetDataType.Skill);
  }

  generateProficienciesHashMap(obj){
    let _this = this;
    let mapOfProficiencyNamesToProficiencyValues = {};
    Object.keys(obj).map(function (k) {
      if (_this.determineCharacterSheetEntryDataType(k) == CharacterSheetDataType.Proficiency) {
        mapOfProficiencyNamesToProficiencyValues[k] = obj[k];
      }
    });
    return mapOfProficiencyNamesToProficiencyValues;
  }

  generateArrayOfDataTypePassedIn(obj, dataType: CharacterSheetDataType) {
    let _this = this;
    var arrayRequested = [];
    Object.keys(obj).map(function (k) { //k for key other than the "key" in the arrayOfStats
        if (_this.determineCharacterSheetEntryDataType(k) == dataType) {
          arrayRequested.push( { key: k, value: obj[k]});
        }
    });
    return arrayRequested;
  }

  constructor(private characterService: CharacterService,
              private gameEngine: GameEngineService) {}

  ngOnInit() {
    this.getCharacterSheet();
  }
}
