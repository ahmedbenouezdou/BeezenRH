import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { NgbDateAdapter } from '@ng-bootstrap/ng-bootstrap';

import { NgbDateMomentAdapter } from 'app/shared/util/datepicker-adapter';
import { BeezenRhSharedLibsModule, BeezenRhSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from 'app/shared';

@NgModule({
    imports: [BeezenRhSharedLibsModule, BeezenRhSharedCommonModule],
    declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
    providers: [{ provide: NgbDateAdapter, useClass: NgbDateMomentAdapter }],
    entryComponents: [JhiLoginModalComponent],
    exports: [BeezenRhSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BeezenRhSharedModule {}
