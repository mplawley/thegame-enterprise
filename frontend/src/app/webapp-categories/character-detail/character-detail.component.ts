import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-character-detail',
  templateUrl: './character-detail.component.html',
  styleUrls: ['./character-detail.component.css']
})
export class CharacterDetailComponent implements OnInit {

  @Input() selectedCharacterSheetItem: string;
  @Input() currentPerformance: number;

  constructor() { }

  ngOnInit() {
  }
}
