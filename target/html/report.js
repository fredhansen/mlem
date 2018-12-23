$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("navigationAsAdmin.feature");
formatter.feature({
  "line": 1,
  "name": "Navigating in app as administrator",
  "description": "",
  "id": "navigating-in-app-as-administrator",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 8,
  "name": "can navigate to forbidden pages",
  "description": "",
  "id": "navigating-in-app-as-administrator;can-navigate-to-forbidden-pages",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "I opened homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I go to different pages \"\u003cpage\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I should see correct div\u0027s on screen \"\u003cdiv\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "navigating-in-app-as-administrator;can-navigate-to-forbidden-pages;",
  "rows": [
    {
      "cells": [
        "page",
        "div"
      ],
      "line": 14,
      "id": "navigating-in-app-as-administrator;can-navigate-to-forbidden-pages;;1"
    },
    {
      "cells": [
        "products/add",
        "name"
      ],
      "line": 15,
      "id": "navigating-in-app-as-administrator;can-navigate-to-forbidden-pages;;2"
    },
    {
      "cells": [
        "products/warehouse",
        "searchInputBox"
      ],
      "line": 16,
      "id": "navigating-in-app-as-administrator;can-navigate-to-forbidden-pages;;3"
    },
    {
      "cells": [
        "stats",
        "oschart"
      ],
      "line": 17,
      "id": "navigating-in-app-as-administrator;can-navigate-to-forbidden-pages;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 2997544800,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Administrator is logged in",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "I opened homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I login",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "NavigationSteps.iOpenedHomepage()"
});
formatter.result({
  "duration": 306752300,
  "status": "passed"
});
formatter.match({
  "location": "NavigationSteps.iLogin()"
});
