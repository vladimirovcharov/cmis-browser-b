Meta:

Narrative:
As a content management system (CMS) user
I want to use simple search
So that I can find content by using a simple criteria

Scenario: User uses simple search, checks pagination and checks returning to previous state

Given opened 'http://localhost:18080/browser'
When types 'Doc' on './/*[contains(@id,"searchInput")]'
And clicks on './/*[contains(@id,"searchbtn")]'
Then find 'My_Document-0-1' on '(.//*[contains(@id,"table") and contains(@id,"itemname")])[1]'
When clicks on './/*[contains(@id,'table:butnext')]'
Then find 'My_Document-0-2' on '(.//*[contains(@id,"table") and contains(@id,"itemname")])[1]'
When clicks on './/*[contains(@id,'butprev')]'
Then find 'My_Document-0-1' on '(.//*[contains(@id,"table") and contains(@id,"itemname")])[1]'
When clicks on './/*[contains(@id,'butlast')]'
Then find 'My_Document-0-2' on '(.//*[contains(@id,"table") and contains(@id,"itemname")])[1]'
When clicks on './/*[contains(@id,'butfirst')]'
Then find 'My_Document-0-1' on '(.//*[contains(@id,"table") and contains(@id,"itemname")])[1]'
When clears text in './/*[contains(@id,"searchInput")]'
And clicks on './/*[contains(@id,"searchbtn")]'
Then find 'My_Document-0-0' on '(.//*[contains(@id,"table") and contains(@id,"itemname")])[1]'
And find 'My_Document-0-1' on '(.//*[contains(@id,"table") and contains(@id,"itemname")])[2]'