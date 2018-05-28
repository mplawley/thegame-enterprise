// import { CharacterSheetDataObject, Proficiency, CharacterSheetVitals } from "./characterSheet";
// import { Power, Action } from './power';
// import { InMemoryDbService } from 'angular-in-memory-web-api';

// export class InMemoryDataService implements InMemoryDbService {
//   createDb() {
//     const CHARACTER_VITALS: CharacterSheetVitals = {
//       characterName: "Gloria",
//       age: 33,
//       bio: "Test bio", 
//       currentLife: 100, 
//       maxLife: 100, 
//       currentEndurance: 10, 
//       maxEndurance: 10 
//     };

//     const BASE_STATS: CharacterSheetDataObject[] = [
//       {skillName: "Speed", skillValue: 3, skillProficiency: Proficiency.Journeyman},
//       {skillName: "Assessment", skillValue: 7, skillProficiency: Proficiency.Journeyman},
//       {skillName: "Insight", skillValue: 6, skillProficiency: Proficiency.Journeyman},
//       {skillName: "Spirit", skillValue: 6, skillProficiency: Proficiency.Journeyman},
//       {skillName: "Coordination", skillValue: 4, skillProficiency: Proficiency.Journeyman},
//       {skillName: "Strength", skillValue: 3, skillProficiency: Proficiency.Journeyman},
//       {skillName: "Fortitude", skillValue: 2, skillProficiency: Proficiency.Journeyman},
//       {skillName: "Wisdom", skillValue: 5, skillProficiency: Proficiency.Journeyman},
//       {skillName: "Will", skillValue: 3, skillProficiency: Proficiency.Journeyman},
//       {skillName: "Charisma", skillValue: 100, skillProficiency: Proficiency.Journeyman}
//     ];
    
//     const SKILLS: CharacterSheetDataObject[] = [
//       {skillName: "Martial", skillValue: 3, skillProficiency: Proficiency.Apprentice},
//       {skillName: "Ranged", skillValue: 2, skillProficiency: Proficiency.Journeyman},
//       {skillName: "Stealth", skillValue: 4, skillProficiency: Proficiency.Master},
//       {skillName: "Athletics", skillValue: 6, skillProficiency: Proficiency.Legend},
//       {skillName: "Lore", skillValue: 3, skillProficiency: Proficiency.Epic},
//       {skillName: "Scouting", skillValue: 2, skillProficiency: Proficiency.Apprentice},
//       {skillName: "Crafting", skillValue: 4, skillProficiency: Proficiency.Journeyman},
//       {skillName: "Alchemy", skillValue: 6, skillProficiency: Proficiency.Master},
//       {skillName: "Arts", skillValue: 4, skillProficiency: Proficiency.Grandmaster},
//       {skillName: "Diplomacy", skillValue: 100, skillProficiency: Proficiency.Legend}
//     ];

//     const powers: Power[] = [
//       {powerId: 0, powerName: "Fireball", powerCost: 1, powerRange: 5, powerAction: Action.Small, powerMagnitude: 10, powerShortDescription: "A fireball, zzzz!", powerLongDescription: "This is a long description placeholder for the fireball spell!", powerNotes: ""  },
//       {powerId: 1, powerName: "Ice spear", powerCost: 1, powerRange: 10, powerAction: Action.Small, powerMagnitude: 5, powerShortDescription: "A lance of ice.", powerLongDescription: "This is a long description placeholder for the lance of ice spell!!", powerNotes: ""  },
//       {powerId: 2, powerName: "Boulder blast", powerCost: 1, powerRange: 3, powerAction: Action.Round, powerMagnitude: 15, powerShortDescription: "A close-range blast of rocks.", powerLongDescription: "This is a long description placeholder for the boulder blast spell!", powerNotes: ""  }
//     ];

//     return {CHARACTER_VITALS, BASE_STATS, SKILLS, powers};
//   }
// }
