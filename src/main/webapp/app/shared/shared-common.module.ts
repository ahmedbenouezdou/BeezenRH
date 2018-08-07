import { NgModule } from '@angular/core';

import { ProjetRhSharedLibsModule, FindLanguageFromKeyPipe, JhiAlertComponent, JhiAlertErrorComponent } from 'app/shared';

@NgModule({
    imports: [ProjetRhSharedLibsModule],
    declarations: [FindLanguageFromKeyPipe, JhiAlertComponent, JhiAlertErrorComponent],
    exports: [ProjetRhSharedLibsModule, FindLanguageFromKeyPipe, JhiAlertComponent, JhiAlertErrorComponent]
})
export class ProjetRhSharedCommonModule {}
