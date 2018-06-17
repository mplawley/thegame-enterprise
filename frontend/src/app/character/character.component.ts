import { Component, OnInit } from '@angular/core';
import { CharacterSheet, CharacterSheetClickableItems, Proficiency, CharacterSheetVitals } from '../characterSheet';
import { GameEngine } from '../gameEngine';
import { CharacterService } from '../character.service';
import { ProficiencyStringPipe } from '../proficiency-int-to-string-pipe';

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

  selectedCharacterSheetItem: CharacterSheetClickableItems;
  currentPerformance: number;
  proficiency: Proficiency = Proficiency.Apprentice;

  onSelectStat(characterSheetItem: CharacterSheetClickableItems, i: number): void {
    this.selectedCharacterSheetItem = characterSheetItem;
    this.currentPerformance = this.gameEngine.calculateStatPerformance(this.characterSheetBaseStats[i].skillValue);
  }

  onSelectSkill(characterSheetItem: CharacterSheetClickableItems, i: number): void {
    this.selectedCharacterSheetItem = characterSheetItem;
    this.proficiency = this.characterSheetSkills[i].skillProficiency;
    this.currentPerformance = this.gameEngine.calculateSkillPerformance(this.characterSheetSkills[i].skillName,
                                                                        this.characterSheetBaseStats[i].skillValue,
                                                                        this.characterSheetSkills[i].skillValue,
                                                                        this.characterSheetSkills[i].skillProficiency);
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
      .subscribe(characterSheetObject => this.characterSheet = characterSheetObject);
  }

  transformObjectToIterable(objectToTransform): any {
    let iterableObjectProperties = Object.keys(objectToTransform);
    let iterableObject = [];
    for (let prop of iterableObjectProperties) { 
      iterableObject.push(iterableObjectProperties[prop]);
    }

    return iterableObject;
  }

  constructor(private characterService: CharacterService) {}

  ngOnInit() {
    // this.getVitals();
    // this.getStats();
    // this.getSkills();
    this.getCharacterSheet();
  }
}
