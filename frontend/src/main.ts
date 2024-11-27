// main.ts
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app.module';  // Importation du module principal de l'application

// Bootstrap de l'application Angular
platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));  // En cas d'erreur, on affiche l'erreur dans la console
