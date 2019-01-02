import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GnomeServerSharedModule } from 'app/shared';
import {
    ProfessionComponent,
    ProfessionDetailComponent,
    ProfessionUpdateComponent,
    ProfessionDeletePopupComponent,
    ProfessionDeleteDialogComponent,
    professionRoute,
    professionPopupRoute
} from './';

const ENTITY_STATES = [...professionRoute, ...professionPopupRoute];

@NgModule({
    imports: [GnomeServerSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        ProfessionComponent,
        ProfessionDetailComponent,
        ProfessionUpdateComponent,
        ProfessionDeleteDialogComponent,
        ProfessionDeletePopupComponent
    ],
    entryComponents: [ProfessionComponent, ProfessionUpdateComponent, ProfessionDeleteDialogComponent, ProfessionDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GnomeServerProfessionModule {}
