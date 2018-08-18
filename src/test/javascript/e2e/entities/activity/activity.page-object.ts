import { element, by, promise, ElementFinder } from 'protractor';

export class ActivityComponentsPage {
    createButton = element(by.id('jh-create-entity'));
    title = element.all(by.css('jhi-activity div h2#page-heading span')).first();

    clickOnCreateButton(): promise.Promise<void> {
        return this.createButton.click();
    }

    getTitle(): any {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class ActivityUpdatePage {
    pageTitle = element(by.id('jhi-activity-heading'));
    saveButton = element(by.id('save-entity'));
    cancelButton = element(by.id('cancel-save'));
    activityLabelInput = element(by.id('field_activityLabel'));
    dateDebutInput = element(by.id('field_dateDebut'));
    dateFinInput = element(by.id('field_dateFin'));
    isValideInput = element(by.id('field_isValide'));
    activityTypeInput = element(by.id('field_activityType'));
    userSelect = element(by.id('field_user'));

    getPageTitle() {
        return this.pageTitle.getAttribute('jhiTranslate');
    }

    setActivityLabelInput(activityLabel): promise.Promise<void> {
        return this.activityLabelInput.sendKeys(activityLabel);
    }

    getActivityLabelInput() {
        return this.activityLabelInput.getAttribute('value');
    }

    setDateDebutInput(dateDebut): promise.Promise<void> {
        return this.dateDebutInput.sendKeys(dateDebut);
    }

    getDateDebutInput() {
        return this.dateDebutInput.getAttribute('value');
    }

    setDateFinInput(dateFin): promise.Promise<void> {
        return this.dateFinInput.sendKeys(dateFin);
    }

    getDateFinInput() {
        return this.dateFinInput.getAttribute('value');
    }

    getIsValideInput() {
        return this.isValideInput;
    }
    setActivityTypeInput(activityType): promise.Promise<void> {
        return this.activityTypeInput.sendKeys(activityType);
    }

    getActivityTypeInput() {
        return this.activityTypeInput.getAttribute('value');
    }

    userSelectLastOption(): promise.Promise<void> {
        return this.userSelect
            .all(by.tagName('option'))
            .last()
            .click();
    }

    userSelectOption(option): promise.Promise<void> {
        return this.userSelect.sendKeys(option);
    }

    getUserSelect(): ElementFinder {
        return this.userSelect;
    }

    getUserSelectedOption() {
        return this.userSelect.element(by.css('option:checked')).getText();
    }

    save(): promise.Promise<void> {
        return this.saveButton.click();
    }

    cancel(): promise.Promise<void> {
        return this.cancelButton.click();
    }

    getSaveButton(): ElementFinder {
        return this.saveButton;
    }
}
