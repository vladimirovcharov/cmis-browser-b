Meta:

Narrative:
As a content management system (CMS) user
I want to use advanced search
So that I can find content by using advanced criterias

Scenario: User uses advanced search and find content

Given opened 'http://localhost:18080/browser'
Then './/div[contains(@id,'accordionAdvancedSearch') and contains(@aria-hidden,"true")]' is visible on the page
When clicks on './/div[contains(@id,'accordionAdvancedSearch')]//span[contains(@class,"ui-icon-triangle-1-e")]'
Then './/div[contains(@id,'accordionAdvancedSearch') and contains(@aria-hidden,"false")]' is visible on the page
When clicks on './/div[contains(@id,'searchDocumentType')]/div[3]/span'
And clicks on './/*[contains(@id,'typeDocument')'
And clicks on './/*[contains(@id,'searchDateFrom')]/button'
And clicks on './/*[contains(@id,'ui-datepicker-div')]/table/tbody/tr[1]/td[2]/a'
And clicks on './/*[contains(@id,'searchDateTo')]/button'
And clicks on './/*[contains(@id,'ui-datepicker-div')]/table/tbody/tr[5]/td[4]/a'
And clicks on './/*[contains(@id,'searchSize')]'
And clears text in './/*[contains(@id,'searchSize')]'
And types '33581' on './/*[contains(@id,'searchText')]'
And types 'Lorem' on './/*[contains(@id,'searchText')]'
And clicks on './/*[contains(@id,"searchbtn")]'
Then find 'My_Document-0-0' on '(.//*[contains(@id,"table") and contains(@id,"itemname")])[1]'
And wait

!--Scenario: User uses advanced search and doesn't find content
!--
!--Given opened 'http://localhost:18080/browser'
