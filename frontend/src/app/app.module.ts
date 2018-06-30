import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { CharacterComponent } from './character/character.component';
import { EnemiesComponent } from './enemies/enemies.component';
import { CharacterDetailComponent } from './character-detail/character-detail.component';
import { ProficiencyStringPipe } from './proficiency-int-to-string-pipe';
import { CharacterService } from './character.service';
import { MessagesComponent } from './messages/messages.component';
import { MessageService } from './message.service';
import { PowerService } from './power.service';
import { AppRoutingModule } from './/app-routing.module';
import { InventoryComponent } from './inventory/inventory.component';
import { BioComponent } from './characterBio/characterBio.component';
import { MeritsAndBuffsComponent } from './merits-and-buffs/merits-and-buffs.component';
import { PowersComponent } from './powers/powers.component';
import { ItemsComponent } from './items/items.component';
import { LevelUpComponent } from './level-up/level-up.component';
import { SettingsComponent } from './settings/settings.component';
import { PowersDetailComponent } from './powers-detail/powers-detail.component';
import { NotesComponent } from './notes/notes.component';

import { HttpClientModule } from '@angular/common/http';
//import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
// import { InMemoryDataService} from './in-memory-data.service';

@NgModule({
  declarations: [
    AppComponent,
    CharacterComponent,
    EnemiesComponent,
    CharacterDetailComponent,
    ProficiencyStringPipe,
    MessagesComponent,
    InventoryComponent,
    BioComponent,
    MeritsAndBuffsComponent,
    PowersComponent,
    ItemsComponent,
    LevelUpComponent,
    SettingsComponent,
    PowersDetailComponent,
    NotesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule

    // The HttpClientInMemoryWebApiModule module intercepts HTTP requests
    // and returns simulated server responses.
    // Remove it when a real server is ready to receive requests.
    // HttpClientInMemoryWebApiModule.forRoot(
    //   InMemoryDataService, { dataEncapsulation: false }
    // )
  ],
  providers: [
    CharacterService,
    PowerService,
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
