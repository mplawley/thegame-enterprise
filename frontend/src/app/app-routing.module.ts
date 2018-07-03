import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { CharacterComponent } from './webapp-categories/character/character.component';
import { BioComponent } from './webapp-categories/bio/bio.component';
import { InventoryComponent } from './webapp-categories/inventory/inventory.component';
import { MeritsAndBuffsComponent } from './webapp-categories/merits-and-buffs/merits-and-buffs.component';
import { PowersComponent } from './webapp-categories/powers/powers.component';
import { PowersDetailComponent } from './webapp-categories/powers-detail/powers-detail.component';
import { ItemsComponent } from './webapp-categories/items/items.component';
import { LevelUpComponent } from './webapp-categories/level-up/level-up.component';
import { SettingsComponent } from './webapp-categories/settings/settings.component';

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
