# Notes

Please add here any notes, assumptions and design decisions that might help up understand your though process.

I've only added the TwoForOneDiscounter which implements Discounter. I imagine that adding another will require
another parent discounter to combine and determine the best discount.

Pending issues:
* How do we calculate the best discount? Ordering will be important of discounters when products can be in multiple promotions.
* Product/WeighedProduct don't have a shared parent which is not yet a problem but may do when adding more promotions.
* Products and ItemX are only compared currently by reference. SKUs/Codes will be more useful.
* The discounter only returns a single value of the discount - in a real receipt the discounts are listed with a description as well.
This will be need to be managed when multiple promotions are applied by use of a composite object.

