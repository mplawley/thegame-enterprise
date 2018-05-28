import { Component, OnInit, Input } from '@angular/core';
import { CharacterSheetClickableItems } from '../characterSheet';

@Component({
  selector: 'app-character-detail',
  templateUrl: './character-detail.component.html',
  styleUrls: ['./character-detail.component.css']
})
export class CharacterDetailComponent implements OnInit {

  @Input() selectedCharacterSheetItem: CharacterSheetClickableItems;
  @Input() currentPerformance: number;

  constructor() { }

  ngOnInit() {
  }
}
