import { Component, OnInit } from '@angular/core';
import { Character, CharacterSheetClickableItems, Proficiency } from '../characterSheet';
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
  characterSheetVitals;

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

  getVitals(): void {
    this.characterService.getVitals()
      .subscribe(vitals => this.characterSheetVitals = vitals);
  }

  getStats(): void {
    this.characterService.getStats()
      .subscribe(baseStats => this.characterSheetBaseStats = baseStats)
  }

  getSkills(): void {
    this.characterService.getSkills()
      .subscribe(skills => this.characterSheetSkills = skills);
  }

  constructor(private characterService: CharacterService) {}

  ngOnInit() {
    this.getVitals();
    this.getStats();
    this.getSkills();
  }
}
