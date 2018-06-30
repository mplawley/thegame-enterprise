import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { CharacterComponent } from './character/character.component';
import { BioComponent } from './characterBio/characterBio.component';
import { InventoryComponent } from './inventory/inventory.component';
import { MeritsAndBuffsComponent } from './merits-and-buffs/merits-and-buffs.component';
import { PowersComponent } from './powers/powers.component';
import { PowersDetailComponent } from './powers-detail/powers-detail.component';
import { ItemsComponent } from './items/items.component';
import { LevelUpComponent } from './level-up/level-up.component';
import { SettingsComponent } from './settings/settings.component';

const routes: Routes = [
  {path: '', redirectTo: '/character', pathMatch: 'full'},
  {path: 'character', component: CharacterComponent},
  {path: 'characterBio', component: BioComponent},
  {path: 'inventory', component: InventoryComponent},
  {path: 'meritsAndBuffs', component: MeritsAndBuffsComponent},
  {path: 'powers', component: PowersComponent},
  {path: 'powers/:powerId', component: PowersDetailComponent},
  {path: 'items', component: ItemsComponent},
  {path: 'levelup', component: LevelUpComponent},
  {path: 'settings', component: SettingsComponent}
]

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes), HttpClientModule]
})
export class AppRoutingModule { }
