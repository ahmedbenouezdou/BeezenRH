import { browser } from 'protractor';
import { NavBarPage } from '../../page-objects/jhi-page-objects';
import { ActivityComponentsPage, ActivityUpdatePage } from './activity.page-object';

describe('Activity e2e test', () => {
    let navBarPage: NavBarPage;
    let activityUpdatePage: ActivityUpdatePage;
    let activityComponentsPage: ActivityComponentsPage;

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load Activities', () => {
        navBarPage.goToEntity('activity');
        activityComponentsPage = new ActivityComponentsPage();
        expect(activityComponentsPage.getTitle()).toMatch(/beezenRhApp.activity.home.title/);
    });

    it('should load create Activity page', () => {
        activityComponentsPage.clickOnCreateButton();
        activityUpdatePage = new ActivityUpdatePage();
        expect(activityUpdatePage.getPageTitle()).toMatch(/beezenRhApp.activity.home.createOrEditLabel/);
        activityUpdatePage.cancel();
    });

    /* it('should create and save Activities', () => {
        activityComponentsPage.clickOnCreateButton();
        activityUpdatePage.setActivityLabelInput('activityLabel');
        expect(activityUpdatePage.getActivityLabelInput()).toMatch('activityLabel');
        activityUpdatePage.setDateDebutInput('2000-12-31');
        expect(activityUpdatePage.getDateDebutInput()).toMatch('2000-12-31');
        activityUpdatePage.setDateFinInput('2000-12-31');
        expect(activityUpdatePage.getDateFinInput()).toMatch('2000-12-31');
        activityUpdatePage.getIsValideInput().isSelected().then((selected) => {
            if (selected) {
                activityUpdatePage.getIsValideInput().click();
                expect(activityUpdatePage.getIsValideInput().isSelected()).toBeFalsy();
            } else {
                activityUpdatePage.getIsValideInput().click();
                expect(activityUpdatePage.getIsValideInput().isSelected()).toBeTruthy();
            }
        });
        activityUpdatePage.setActivityTypeInput('5');
        expect(activityUpdatePage.getActivityTypeInput()).toMatch('5');
        activityUpdatePage.userSelectLastOption();
        activityUpdatePage.save();
        expect(activityUpdatePage.getSaveButton().isPresent()).toBeFalsy();
    });*/

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});
