import { BasicFormPage } from './app.po';

describe('basic-form App', () => {
  let page: BasicFormPage;

  beforeEach(() => {
    page = new BasicFormPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
