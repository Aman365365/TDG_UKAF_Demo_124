package Runner

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef.{constantUsersPerSec, _}

import scala.concurrent.duration._
import scala.language.postfixOps
import com.intuit.karate.gatling.KarateActionBuilder
import io.gatling.core.structure.ScenarioBuilder


class TDG_UKAF_demo extends Simulation{


  var ServiceTest: ScenarioBuilder = scenario("ServiceTest").exec(karateFeature("classpath:Features/TDG_UKAF_demo.feature"))

  setUp(
    ServiceTest.inject(
      //constantConcurrentUsers (1).during(5 minutes))
      constantUsersPerSec(20).during(15 minutes))
    //  incrementConcurrentUsers (5)
    //  .times(3)
     // .eachLevelLasting(60)
     // .separatedByRampsLasting(15)
    //  .startingFrom(5) // Int
   // )
  )
}