
(ns dynamic-props.env
    (:require [dynamic-props.state :as state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-props
  ; @description
  ; Returns the dynamic properties of the component (stored in the property state atom).
  ;
  ; @param (keyword) component-id
  ; @param (map)(opt) default-props
  ;
  ; @usage
  ; (update-props! :my-component assoc :my-prop "My dynamic property")
  ; (get-props     :my-component)
  ; =>
  ; {:my-prop "My dynamic property"}
  ;
  ; @return (map)
  [component-id & [default-props]]
  (if-let [dynamic-props (get @state/PROPERTIES component-id)]
          (-> default-props (merge dynamic-props))
          (or default-props {})))

(defn get-prop
  ; @description
  ; Returns a specific dynamic property of the component (stored in the property state atom).
  ;
  ; @param (keyword) component-id
  ; @param (keyword) prop-key
  ; @param (map)(opt) default-props
  ;
  ; @usage
  ; (update-props! :my-component assoc :my-prop "My dynamic property")
  ; (get-prop      :my-component :my-prop)
  ; =>
  ; "My dynamic property"
  ;
  ; @return (*)
  [component-id prop-key & [default-props]]
  (if-let [dynamic-props (get-props component-id default-props)]
          (get dynamic-props prop-key)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-props
  ; @description
  ; Merges the dynamic properties of the component (stored in the property state atom) onto the given property map.
  ;
  ; @param (keyword) component-id
  ; @param (map)(opt) component-props
  ; @param (map)(opt) default-props
  ;
  ; @usage
  ; (update-props! :my-component assoc :my-prop "My dynamic property")
  ; (import-props  :my-component {:my-prop "My static property" :another-prop "Another static property"})
  ; =>
  ; {:my-prop      "My dynamic property"
  ;  :another-prop "Another static property"}
  ;
  ; @return (map)
  [component-id & [component-props default-props]]
  (if-let [dynamic-props (get-props component-id default-props)]
          (-> component-props (merge dynamic-props))
          (or component-props {})))
