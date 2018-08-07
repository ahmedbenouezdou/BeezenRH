import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { ProdConfig } from 'app/blocks/config/prod.config';
import { ProjetRhAppModule } from 'app/app.module';

ProdConfig();

if (module['hot']) {
    module['hot'].accept();
}

platformBrowserDynamic()
    .bootstrapModule(ProjetRhAppModule, { preserveWhitespaces: true })
    .then(success => console.log(`Application started`))
    .catch(err => console.error(err));
