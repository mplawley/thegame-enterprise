import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { CharacterComponent } from './webapp-categories/character/character.component';
import { CharacterDetailComponent } from './webapp-categories/character-detail/character-detail.component';
import { ProficiencyStringPipe } from './pipes/proficiency-int-to-string-pipe';
import { CharacterService } from './services/character.service';
import { MessagesComponent } from './webapp-categories/messages/messages.component';
import { MessageService } from './services/message.service';
import { GameEngineService } from './services/gameEngine.service';
import { PowerService } from './services/power.service';
import { AppRoutingModule } from './/app-routing.module';
import { InventoryComponent } from './webapp-categories/inventory/inventory.component';
import { BioComponent } from './webapp-categories/bio/bio.component';
import { MeritsAndBuffsComponent } from './webapp-categories/merits-and-buffs/merits-and-buffs.component';
import { PowersComponent } from './webapp-categories/powers/powers.component';
import { ItemsComponent } from './webapp-categories/items/items.component';
import { LevelUpComponent } from './webapp-categories/level-up/level-up.component';
import { SettingsComponent } from './webapp-categories/settings/settings.component';
import { PowersDetailComponent } from './webapp-categories/powers-detail/powers-detail.component';
import { NotesComponent } from './webapp-categories/notes/notes.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './webapp-categories/login/login.component';

//import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
// import { InMemoryDataService} from './in-memory-data.service';

@NgModule({
  declarations: [
    AppComponent,
    CharacterComponent,
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
    NotesComponent,
    LoginComponent
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
    MessageService,
    GameEngineService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
