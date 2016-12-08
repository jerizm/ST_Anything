/**
 *  ST_Anything_RCSwitch - ST_Anything_RCSwitch.device.groovy
 *
 *  Copyright 2015 Daniel Ogorchock
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 *  Change History:
 *
 *    Date        Who            What
 *    ----        ---            ----
 *    2015-01-31  Dan Ogorchock  Original Creation
 *
 *
 */

metadata {
  definition (name: "ST_Anything_RCSwitch", namespace: "ogiewon", author: "Daniel Ogorchock") {
    capability "Switch"

      attribute "rcswitch1", "string"
      attribute "rcswitch2", "string"
      attribute "rcswitch3", "string"
      attribute "rcswitch4", "string"
      attribute "rcswitch5", "string"

      command "rcswitch1on"
      command "rcswitch1off"
      command "rcswitch2on"
      command "rcswitch2off"
      command "rcswitch3on"
      command "rcswitch3off"
      command "rcswitch4on"
      command "rcswitch4off"
      command "rcswitch5on"
      command "rcswitch5off"
  }

  simulator {
  }


  // tile definitions
  tiles {

    standardTile("rcswitch1", "device.rcswitch1", width: 1, height: 1, canChangeIcon: true) {
      state "off", label: '${name}', action: "rcswitch1on", icon: "st.switches.switch.off", backgroundColor: "#ffffff"
        state "on", label: '${name}', action: "rcswitch1off", icon: "st.switches.switch.on", backgroundColor: "#79b821"
    }

    standardTile("rcswitch2", "device.rcswitch2", width: 1, height: 1, canChangeIcon: true) {
      state "off", label: '${name}', action: "rcswitch2on", icon: "st.switches.switch.off", backgroundColor: "#ffffff"
        state "on", label: '${name}', action: "rcswitch2off", icon: "st.switches.switch.on", backgroundColor: "#79b821"
    }

    standardTile("rcswitch3", "device.rcswitch3", width: 1, height: 1, canChangeIcon: true) {
      state "off", label: '${name}', action: "rcswitch3on", icon: "st.switches.switch.off", backgroundColor: "#ffffff"
        state "on", label: '${name}', action: "rcswitch3off", icon: "st.switches.switch.on", backgroundColor: "#79b821"
    }

    standardTile("rcswitch4", "device.rcswitch1", width: 1, height: 1, canChangeIcon: true) {
      state "off", label: '${name}', action: "rcswitch4on", icon: "st.switches.switch.off", backgroundColor: "#ffffff"
        state "on", label: '${name}', action: "rcswitch4off", icon: "st.switches.switch.on", backgroundColor: "#79b821"
    }

    standardTile("rcswitch5", "device.rcswitch1", width: 1, height: 1, canChangeIcon: true) {
      state "off", label: '${name}', action: "rcswitch5on", icon: "st.switches.switch.off", backgroundColor: "#ffffff"
        state "on", label: '${name}', action: "rcswitch5off", icon: "st.switches.switch.on", backgroundColor: "#79b821"
    }

    main (["rcswitch1","rcswitch2","rcswitch3","rcswitch4","rcswitch5"])
      details(["rcswitch1","rcswitch2","rcswitch3","rcswitch4","rcswitch5"])
  }
}

//Map parse(String description) {
def parse(String description) {
  def msg = zigbee.parse(description)?.text
    log.debug "Parse got '${msg}'"

    def parts = msg.split(" ")
    def name  = parts.length>0?parts[0].trim():null
    def value = parts.length>1?parts[1].trim():null

    name = value != "ping" ? name : null

    def result = createEvent(name: name, value: value, isStateChange: true)

    log.debug result

    return result
}

def rcswitch1on() {
  log.debug "Executing 'rcswitch1on' = 'rcswitch1 on'"
    zigbee.smartShield(text: "rcswitch1 on").format()
}

def rcswitch1off() {
  log.debug "Executing 'rcswitch1off' = 'rcswitch1 off'"
    zigbee.smartShield(text: "rcswitch1 off").format()
}

def rcswitch2on() {
  log.debug "Executing 'rcswitch2on' = 'rcswitch2 on'"
    zigbee.smartShield(text: "rcswitch2 on").format()
}

def rcswitch2off() {
  log.debug "Executing 'rcswitch2off' = 'rcswitch2 off'"
    zigbee.smartShield(text: "rcswitch2 off").format()
}

def rcswitch3on() {
  log.debug "Executing 'rcswitch3on' = 'rcswitch3 on'"
    zigbee.smartShield(text: "rcswitch3 on").format()
}

def rcswitch3off() {
  log.debug "Executing 'rcswitch3off' = 'rcswitch3 off'"
    zigbee.smartShield(text: "rcswitch3 off").format()
}

def rcswitch4on() {
  log.debug "Executing 'rcswitch4on' = 'rcswitch4 on'"
    zigbee.smartShield(text: "rcswitch4 on").format()
}

def rcswitch4off() {
  log.debug "Executing 'rcswitch4off' = 'rcswitch4 off'"
    zigbee.smartShield(text: "rcswitch4 off").format()
}

def rcswitch5on() {
  log.debug "Executing 'rcswitch5on' = 'rcswitch5 on'"
    zigbee.smartShield(text: "rcswitch5 on").format()
}

def rcswitch5off() {
  log.debug "Executing 'rcswitch5off' = 'rcswitch5 off'"
    zigbee.smartShield(text: "rcswitch5 off").format()
}
