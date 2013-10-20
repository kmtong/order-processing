Order Processing Skeleton
=========================

This project aims at demostrate order processing using Apache ServiceMix.

* Single Order INBOX
* Extensible Source Order Format Processing (eBay, Amazon, etc)
* Conversion to Internal Standard Order Format
* Order Dispatcher Queue to Process Standardized Orders
* Flexible Order Processing Steps


Order Related Processes
=======================

* Order Source Format Conversion
* Order Validation
* Order Payment Confirmation
* Warehouse Fulfillment Decision and Dispatching
* Stock Out
* Combine/Split Orders for Packaging
* Logistic Provider Determination
* Tracking Number and Options (e.g. Registered, Insurance) Handling
* Label Printing, Pickup, Packaging
* Package Sorting by Logistic Providers
* Cost Consolidation

Extension Points
================

* Sales Platform: Order Format Conversion
* Validation Process
* Payment Confirmation with Human Interventions
* Warehouse Type and Integration
* Combine/Split Package Rules
* Logistic Provider: Selection Rules, Cost Calculation
* Sales Platform: Upload Tracking Number
* Logistic Provider: Tracking Number, Label Format, Options, Integration

Modules
=======

* Sales Platform API / SPI
* Validation API / SPI
* Payment API / SPI
* Warehouse API / SPI
* Packaging API / SPI
* Logistic API / SPI
* Core Processor


